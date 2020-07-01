package com.dropoutsolutions.betterhalf.Adaptor;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dropoutsolutions.betterhalf.Fragment.Gender;
import com.dropoutsolutions.betterhalf.Fragment.ProfileFragment;
import com.dropoutsolutions.betterhalf.GetString;
import com.dropoutsolutions.betterhalf.MaritalstatusActivity;
import com.dropoutsolutions.betterhalf.NicknameActivity;
import com.dropoutsolutions.betterhalf.ProfileimageActivity;
import com.dropoutsolutions.betterhalf.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfessionAdaptor extends RecyclerView.Adapter<ProfessionAdaptor.MyViewHolder> {
    private ArrayList<String> text = new ArrayList<>();
    private Context context ;
    String nickname  ;
    String dob ;
    String gender ;
    private int row_index ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;


    public ProfessionAdaptor(ArrayList<String> text, Context context, String nickname, String dob, String gender) {
        this.text = text;
        this.context = context;
        this.nickname = nickname;
        this.dob = dob;
        this.gender = gender;
    }

    @NonNull
    @Override
    public ProfessionAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.professionrecylerlayout, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull final ProfessionAdaptor.MyViewHolder holder, final int position) {




        holder.item.setText(text.get(position));
        holder.item.setOnClickListener(v -> {

            row_index = position;
            notifyDataSetChanged();
            if (row_index == position)
            {
                savedata(text.get(row_index));


            }
        });

        if (row_index == 0)
        {
            holder.item.setBackgroundResource(R.drawable.resetbackground);
        }

        else if (row_index == position)
        {
            holder.item.setBackgroundResource(R.drawable.edittextback);
            holder.item.setPadding(20,10,20,10);

        }
        else
        {
            holder.item.setBackgroundResource(R.drawable.resetbackground);
        }
    }
    private void savedata(String s) {
        Intent intent = new Intent(context , MaritalstatusActivity.class);
        intent.putExtra("gender" , gender);
        intent.putExtra("nickname" , nickname);
        intent.putExtra("dob" , dob);
        intent.putExtra("profession" ,s);
        context.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        return text.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.profession);
        }
    }
}
