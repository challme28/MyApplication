package dis.teph.myapplication;

import android.content.Context;
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
    List<RvInformation> data= Collections.emptyList();

    public RvAdapter (Context context, List<RvInformation> data){
        this.data=data;
        inflater=LayoutInflater.from(context);
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

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.listText);
            imageView=(ImageView)itemView.findViewById(R.id.listIcon);

        }
    }
}
