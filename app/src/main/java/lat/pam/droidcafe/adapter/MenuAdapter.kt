package lat.pam.droidcafe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lat.pam.droidcafe.databinding.ItemMenuBinding
import lat.pam.droidcafe.model.MenuItem

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onItemClick: (MenuItem) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            tvMenuTitle.text = item.name
            tvMenuDesc.text = "- ${item.description}"
            tvMenuPrice.text = "- ${item.formattedPrice}"
            imgMenu.setImageResource(item.imageResId)

            btnOrder.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}
