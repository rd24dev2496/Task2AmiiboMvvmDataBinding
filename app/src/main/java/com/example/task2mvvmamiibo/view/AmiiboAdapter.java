package com.example.task2mvvmamiibo.view;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.task2mvvmamiibo.R;
import com.example.task2mvvmamiibo.databinding.ItemAmiiboListBinding;
import com.example.task2mvvmamiibo.model.Amiibo;
import com.example.task2mvvmamiibo.viewmodel.ItemAmiiboViewModel;
import java.util.Collections;
import java.util.List;
public class AmiiboAdapter  extends RecyclerView.Adapter<AmiiboAdapter.AmiiboAdapterViewHolder> {
    private List<Amiibo> amiiboList;
    AmiiboAdapter() {
        this.amiiboList = Collections.emptyList();
    }
    @NonNull
    @Override
    public AmiiboAdapter.AmiiboAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ItemAmiiboListBinding itemAmiiboListBinding=
               DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_amiibo_list,parent,false);
        return new AmiiboAdapterViewHolder(itemAmiiboListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AmiiboAdapter.AmiiboAdapterViewHolder holder, int position) {

        holder.bindAmiibo(amiiboList.get(position));
    }

    @Override
    public int getItemCount() {
        return amiiboList.size();
    }
    void setPeopleList(List<Amiibo> amiiboList) {
        this.amiiboList = amiiboList;
        notifyDataSetChanged();
    }

    public static class AmiiboAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemAmiiboListBinding binding;
        public AmiiboAdapterViewHolder( ItemAmiiboListBinding binding) {
            super(binding.itemPeople);
            this.binding=binding;
        }
        void bindAmiibo(Amiibo amiibo)
        {
            if(binding.getAmiiboViewModel()==null)
            {
                binding.setAmiiboViewModel(new ItemAmiiboViewModel(itemView.getContext(),amiibo));
            }else {
                binding.getAmiiboViewModel().setPeople(amiibo);
            }
        }
    }
}

