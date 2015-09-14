package dis.teph.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by siete on 07/09/2015.
 */
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ClickListener clickListener;
    List<RvInformation> data= Collections.emptyList();


    public RvAdapter (Context context, List<RvInformation> data){
        this.data=data;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    public void deleteRow(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view=inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RvInformation currentObj= data.get(position);
        holder.textView.setText(currentObj.title);
        holder.imageView.setImageResource(currentObj.iconID);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.listText);
            imageView=(ImageView)itemView.findViewById(R.id.listIcon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //deleteRow(getAdapterPosition());
            //context.startActivity(new Intent(context, SubActivity.class));
            if(clickListener!=null){
                clickListener.itemClicked(v,getAdapterPosition());
            }
        }
    }

    public interface ClickListener{
        public void itemClicked(View view, int position);
    }
}
