package com.taquangtu.stackoverflowuser.Adapters;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.taquangtu.stackoverflowuser.Base.BaseListAdapter;
import com.taquangtu.stackoverflowuser.Base.BaseViewHolder;
import com.taquangtu.stackoverflowuser.Model.User;
import com.taquangtu.stackoverflowuser.R;

import java.util.Date;

public class UserListAdapter extends BaseListAdapter {

    @Override
    public BaseViewHolder newViewHolder(View parent) {
        return  new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_user, (ViewGroup) parent,false));
    }

    @Override
    public void bindData(BaseViewHolder holder, final int position) {
        final User user = (User) mData.get(position);
        UserViewHolder userViewHolder = (UserViewHolder) holder;
        Picasso.get()
                .load(user.getmProfileImage())
                .fit()
                .into(((UserViewHolder) holder).imvAvatar);
        userViewHolder.name.setText("Name: "+user.getmName());
        userViewHolder.location.setText("Location: "+user.getmLocation());
        String dateString = DateFormat.format("MM/dd/yyyy", new Date(user.getmAccessDate())).toString();
        userViewHolder.accessDate.setText("Last access date: "+dateString );
        userViewHolder.reputation.setText("Reputation: "+user.getmReputation());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(user,position,v);
            }
        });
    }

    public class UserViewHolder extends BaseViewHolder {
        public ImageView imvAvatar;
        public TextView name, location, accessDate;
        public TextView reputation;

        public UserViewHolder(View view) {
            super(view);
            imvAvatar = view.findViewById(R.id.imvAvatar);
            name = view.findViewById(R.id.tvName);
            location = view.findViewById(R.id.tvLocation);
            accessDate = view.findViewById(R.id.tvAccessDate);
            reputation = view.findViewById(R.id.tvReputation);
        }
    }
}
