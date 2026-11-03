package lat.pam.kopidannyemil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onItemClick: (MenuItem) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivFotoMenu: ImageView = view.findViewById(R.id.ivFotoMenu)
        val tvNamaMenu: TextView = view.findViewById(R.id.tvNamaMenu)
        val tvDeskripsiMenu: TextView = view.findViewById(R.id.tvDeskripsiMenu)
        val tvHargaMenu: TextView = view.findViewById(R.id.tvHargaMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        holder.ivFotoMenu.setImageResource(item.fotoResId)
        holder.tvNamaMenu.text = item.nama
        holder.tvDeskripsiMenu.text = "• ${item.deskripsi}"
        holder.tvHargaMenu.text = "• ${item.harga}"

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}