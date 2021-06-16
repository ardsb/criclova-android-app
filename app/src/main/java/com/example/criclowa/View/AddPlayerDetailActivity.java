package com.example.criclowa.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.criclowa.Model.PlayerDetails;
import com.example.criclowa.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddPlayerDetailActivity extends AppCompatActivity {
    DatabaseReference myRef;
    TextView txtPLayersName,txtPLayersAge,txtPLayersBorn,txtPlayingCountry,txtPlayerPlayingRole
            ,txtMajorteam,txtPlayerBattingStyle,txtPlayerBowlingStyle;
    Button addMatch,btnChooseFile;


    CircleImageView imageViewProfile;
    StorageReference storageRef;

    private String imageUploadUrl;
    private ProgressDialog uploadProgressDialog;

    public Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_detail);


        storageRef= FirebaseStorage.getInstance().getReference("profile-images");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("player-details");



        txtPLayersName=findViewById(R.id.txtPLayersName);
        txtPLayersAge=findViewById(R.id.txtPLayersAge);
        txtPLayersBorn=findViewById(R.id.txtPLayersBorn);
        txtPlayingCountry=findViewById(R.id.txtPlayingCountry);
        txtPlayerPlayingRole=findViewById(R.id.txtPlayerPlayingRole);
        txtMajorteam=findViewById(R.id.txtMajorteam);
        txtPlayerBattingStyle=findViewById(R.id.txtPlayerBattingStyle);
        txtPlayerBowlingStyle=findViewById(R.id.txtPlayerBowlingStyle);
        imageViewProfile=findViewById(R.id.imageViewProfile);



        uploadProgressDialog = new ProgressDialog(this);
        uploadProgressDialog.setTitle("Adding a Player");
        uploadProgressDialog.setMessage("Please hold tight while we upload the players details");
        uploadProgressDialog.setCancelable(false);
        uploadProgressDialog.setCanceledOnTouchOutside(false);




        btnChooseFile=findViewById(R.id.btnChooseFile);

        btnChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileChoose();
            }
        });



        addMatch=findViewById(R.id.btnAdd);
        addMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fileUploader();


            }
        });

    }

    private void createPlayerOnFirebase(){
        String PLayersName = txtPLayersName.getText().toString().trim();
        String PLayersAge = txtPLayersAge.getText().toString().trim();
        String PLayersBorn = txtPLayersBorn.getText().toString().trim();
        String PlayingCountry = txtPlayingCountry.getText().toString().trim();
        String PlayerPlayingRole = txtPlayerPlayingRole.getText().toString().trim();
        String Majorteam = txtMajorteam.getText().toString().trim();
        String PlayerBattingStyle = txtPlayerBattingStyle.getText().toString().trim();
        String PlayerBowlingStyle = txtPlayerBowlingStyle.getText().toString().trim();



        if(!TextUtils.isEmpty(PLayersName) && !TextUtils.isEmpty(PLayersAge)
                && !TextUtils.isEmpty(PLayersBorn)&& !TextUtils.isEmpty(PlayingCountry)
                && !TextUtils.isEmpty(PlayerPlayingRole) && !TextUtils.isEmpty(Majorteam)
                && !TextUtils.isEmpty(PlayerBattingStyle)
                && !TextUtils.isEmpty(PlayerBowlingStyle)  ){

            addMatch(PLayersName,PLayersAge,PLayersBorn,PlayingCountry,PlayerPlayingRole,
                    Majorteam,PlayerBattingStyle,PlayerBowlingStyle);


        }else {

            Toast.makeText(getApplicationContext(),"Player details cannot be empty"
                    ,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData() !=null)
        {
            imageUri =data.getData();
            imageViewProfile.setImageURI(imageUri);

        }
    }

    private String getExtention(Uri uri)
    {

        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();

        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));

    }

    public void fileUploader(){

        if (imageUri !=null) {
            StorageReference storageReference = storageRef.child(System.currentTimeMillis()
                    + "." + getExtention(imageUri));

            if (imageUri != null)
            {
                if (!uploadProgressDialog.isShowing()) {
                    uploadProgressDialog.show();
                }

                storageReference.putFile(imageUri).continueWithTask(new Continuation<UploadTask
                        .TaskSnapshot, Task<Uri>>()
                {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task)
                            throws Exception
                    {
                        if (!task.isSuccessful())
                        {
                            throw task.getException();
                        }
                        return storageReference.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task)
                    {
                        if (uploadProgressDialog.isShowing()) {
                            uploadProgressDialog.hide();
                        }

                        if (task.isSuccessful())
                        {
                            Uri downloadUri = task.getResult();
                            Log.e("TEST", "then: " + downloadUri.toString());
                            Toast.makeText(AddPlayerDetailActivity.this
                                    ,"New Player Has Added", Toast.LENGTH_LONG)
                                    .show();
                            imageUploadUrl = downloadUri.toString();

                            createPlayerOnFirebase();


                        }else

                        {

                            Toast.makeText(getApplicationContext(), "upload failed: "
                                    + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }


                });


            }


        }else {

            if (uploadProgressDialog.isShowing()) {
                uploadProgressDialog.hide();
            }
            Toast.makeText(this,"No file selected",Toast.LENGTH_LONG).show();
        }

    }

    public void fileChoose(){

        Intent intent = new Intent();
        intent.setType("image/'");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    public void addMatch( String PLayersName, String PLayersAge, String PLayersBorn
            ,String PlayingCountry,String PlayerPlayingRole,String Majorteam
            ,String PlayerBattingStyle,String PlayerBowlingStyle){


        String id = myRef.push().getKey();
        PlayerDetails playerDetails = new PlayerDetails (id, PLayersName,PLayersAge
                ,PLayersBorn,PlayingCountry,PlayerPlayingRole, Majorteam,PlayerBattingStyle
                ,PlayerBowlingStyle,imageUploadUrl);

        myRef.child(id).setValue(playerDetails);
    }
}