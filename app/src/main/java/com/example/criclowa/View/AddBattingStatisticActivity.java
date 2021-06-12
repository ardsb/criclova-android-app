//package com.example.criclowa.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.criclowa.Model.BattingOutputs;
//import com.example.criclowa.Model.PlayerDetails;
//import com.example.criclowa.R;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class AddBattingStatisticActivity extends AppCompatActivity {
//    DatabaseReference myRef;
//
//    TextView txtMatchesStatistic,txtInningsStatistic,txtRunsStaistic,txtHSStatistic
//            ,txtAverageStatistic,txtStrikeRateStatistic,txtHalfCenturyStatistic,txtCenturyStatistic
//            ,txtSixesStatistic,txtfoursStatistic;
//
//    Button btnAddStatistic;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_batting_statistic);
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//
//        PlayerDetails selected = (PlayerDetails) getIntent().getSerializableExtra("Player Details");
//
//        myRef = FirebaseDatabase.getInstance().getReference("batting-statistic").child(selected.getId());
//
//        txtMatchesStatistic=findViewById(R.id.txtMatchesStatistic);
//        txtInningsStatistic=findViewById(R.id.txtInningsStatistic);
//        txtRunsStaistic=findViewById(R.id.txtRunsStaistic);
//        txtHSStatistic=findViewById(R.id.txtHSStatistic);
//        txtAverageStatistic=findViewById(R.id.txtAverageStatistic);
//        txtStrikeRateStatistic=findViewById(R.id.txtStrikeRateStatistic);
//        txtHalfCenturyStatistic=findViewById(R.id.txtHalfCenturyStatistic);
//        txtCenturyStatistic=findViewById(R.id.txtCenturyStatistic);
//        txtSixesStatistic=findViewById(R.id.txtSixesStatistic);
//        txtfoursStatistic=findViewById(R.id.txtfoursStatistic);
//
//        btnAddStatistic=findViewById(R.id.btnAddStatistic);
//        btnAddStatistic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BattingOutputs battingOutputs = new BattingOutputs();
//
//                battingOutputs.setMatches(txtMatchesStatistic.getText().toString().trim());
//                battingOutputs.setInnings(battingOutputs.getInnings());
////                battingOutputs.setMatches(battingOutputs.getMatches());
////                battingOutputs.setMatches(battingOutputs.getMatches());
////                battingOutputs.setMatches(battingOutputs.getMatches());
////                battingOutputs.setMatches(battingOutputs.getMatches());
//
//
//                saveBattingStatistic(battingOutputs);
//            }
//        });
//
//
//
//    }
//
//    public void saveBattingStatistic(BattingOutputs battingOutputs){
//
//        String id = myRef.push().getKey();
//        battingOutputs.setId(id);
//        myRef.child(id).setValue(battingOutputs);
//        Toast.makeText(this,"One Customer is added",Toast.LENGTH_LONG).show();
//
//
//    }
//}