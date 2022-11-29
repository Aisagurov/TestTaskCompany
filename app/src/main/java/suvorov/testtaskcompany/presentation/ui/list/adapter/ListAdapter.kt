package suvorov.testtaskcompany.presentation.ui.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskcompany.data.model.local.CompanyEntity
import suvorov.testtaskcompany.databinding.ListItemBinding
import suvorov.testtaskcompany.presentation.ui.list.adapter.clicklistener.ItemClickListener

class ListAdapter(
    private val itemClickListener: ItemClickListener
): RecyclerView.Adapter<ListViewHolder>() {

    private var companiesList = listOf<CompanyEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(companiesList[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return companiesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<CompanyEntity>) {
        companiesList = list
        notifyDataSetChanged()
    }
}