/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.ebtkartask.adapters;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.android.ebtkartask.R;
import com.example.android.ebtkartask.models.response.Client;

import java.util.List;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {


    private List<Client> clients;
    private Context context;


    public UsersAdapter(List<Client> clients,Context context) {
        this.clients = clients;
        this.context=context;
    }


    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.user_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        UsersViewHolder viewHolder = new UsersViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, final int position) {
        holder.tvUName.setText(clients.get(position).getName());
        holder.tvUMobile.setText(clients.get(position).getMobile());
//
//        holder.rlOrders.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, OrderDetailsActivity.class);
//                intent.putExtra("DETAILS", (Serializable) ordersResult.getData().get(position).getOrderDetails());
//                context.startActivity(intent);
//            }
//        });
    }


    @Override
    public int getItemCount() {
        if(clients!=null){
            return clients.size();
        }
        return 0;
    }


    class UsersViewHolder extends RecyclerView.ViewHolder {

        TextView tvUName, tvUMobile;
        RelativeLayout rlUsers;

        public UsersViewHolder(View itemView) {
            super(itemView);
            tvUName=itemView.findViewById(R.id.tv_Uname);
            tvUMobile=itemView.findViewById(R.id.tv_Umobile);
            rlUsers=itemView.findViewById(R.id.rl_users);


        }


    }
}
