package se.miun.dt170g.chefapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChefPage extends AppCompatActivity {

    private RecyclerView orderlist;
    private ChefPageAdapter chefpageadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_page);

        orderlist = findViewById(R.id.order_list);

        chefpageadapter = new ChefPageAdapter(getOrderSample());
        orderlist.setAdapter(chefpageadapter);
        orderlist.setLayoutManager(new LinearLayoutManager(this));
        }

        private List<Order> getOrderSample() {
            List<Order> ordersamples = new ArrayList<>();

            Order ordernr1 = new Order(1,1, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
            ordernr1.setTableNr(1);
            ordernr1.getStarter().add("Tomatsoppa");
            ordernr1.getMainCourse().add("Köttbullar");
            ordernr1.getDessert().add("Bakelse");
            ordersamples.add(ordernr1);


            return ordersamples;
        }
}