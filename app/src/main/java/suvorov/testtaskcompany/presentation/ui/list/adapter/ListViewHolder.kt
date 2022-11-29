package suvorov.testtaskcompany.presentation.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskcompany.data.model.local.CompanyEntity
import suvorov.testtaskcompany.databinding.ListItemBinding
import suvorov.testtaskcompany.presentation.ui.list.adapter.clicklistener.ItemClickListener
import suvorov.testtaskcompany.util.loadImage

class ListViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(model: CompanyEntity, itemClickListener: ItemClickListener) {
        binding.apply {
            idTextView.text = model.id
            nameTextView.text = model.name
            imageView.loadImage(model.img)
            root.setOnClickListener {
                itemClickListener.onItemClick(model.id)
            }
        }
    }
}