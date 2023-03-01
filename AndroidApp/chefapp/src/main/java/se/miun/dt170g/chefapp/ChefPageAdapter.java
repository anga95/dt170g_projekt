package se.miun.dt170g.chefapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.utils.widget.MotionLabel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/*
public class ChefPageAdapter extends RecyclerView.Adapter<ChefPageAdapter.ViewHolder> {

    private List<Order> orders;

    public ChefPageAdapter(List<Order> orders) {
        this.orders = orders;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView table;
        public RecyclerView starter_list;
        public CheckBox checkBoxstarter;

        public RecyclerView maincourse_list;
        public CheckBox checkBoxmaincourse;

        public RecyclerView dessert_list;
        public CheckBox checkBoxdessert;

        public TextView starter;

        public TextView maincourse;

        public TextView dessert;

        public ViewHolder(View itemView) {
            super(itemView);
            table = itemView.findViewById(R.id.table);
            starter_list = itemView.findViewById(R.id.starter_list);
            checkBoxstarter = itemView.findViewById(R.id.checkBoxstarter);
            maincourse_list = itemView.findViewById(R.id.maincourse_list);
            checkBoxmaincourse = itemView.findViewById(R.id.checkBoxmaincourse);
            dessert_list = itemView.findViewById(R.id.dessert_list);
            checkBoxdessert = itemView.findViewById(R.id.checkBoxdessert);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Order order = orders.get(position);

        holder.table.setText("Table" + order.getTableNr());

        if (order.getStarter().size() > 0) {
            holder.starter_list.setVisibility(View.VISIBLE);
            ArrayList<String> starterList = (ArrayList<String>) order.getStarter();
            StringBuilder starterStringBuilder = new StringBuilder();
            for (String starter : starterList) {
                starterStringBuilder.append("- ").append(starter).append("\n");
            }
            holder.starter.setText(starterStringBuilder.toString());
            holder.checkBoxstarter.setChecked(order.starterReady());
        } else {
            holder.starter_list.setVisibility(View.GONE);
        }

        if (order.getMainCourse().size() > 0) {
            holder.maincourse_list.setVisibility(View.VISIBLE);
            ArrayList<String> mainCourseList = (ArrayList<String>) order.getMainCourse();
            StringBuilder mainCourseStringBuilder = new StringBuilder();
            for (String mainCourse : mainCourseList) {
                mainCourseStringBuilder.append("- ").append(mainCourse).append("\n");
            }
            holder.maincourse.setText(mainCourseStringBuilder.toString());
            holder.checkBoxmaincourse.setChecked(order.mainCourseReady());
        } else {
            holder.maincourse_list.setVisibility(View.GONE);
        }

        if (order.getDessert().size() > 0) {
            holder.dessert_list.setVisibility(View.VISIBLE);
            ArrayList<String> dessertList = (ArrayList<String>) order.getDessert();
            StringBuilder dessertStringBuilder = new StringBuilder();
            for (String dessert : dessertList) {
                dessertStringBuilder.append("- ").append(dessert).append("\n");
            }
            holder.dessert.setText(dessertStringBuilder.toString());
            holder.checkBoxdessert.setChecked(order.dessertReady());
        } else {
            holder.dessert_list.setVisibility(View.GONE);
        }

    }


    @Override
    public int getItemCount() {
        return orders.size();
    }
}
*/
