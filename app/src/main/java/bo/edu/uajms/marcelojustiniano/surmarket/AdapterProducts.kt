package bo.edu.uajms.marcelojustiniano.surmarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.recyclerview.widget.RecyclerView
import bo.edu.uajms.marcelojustiniano.surmarket.models.product

class AdapterProducts (
    private val productsList: List<product>,
    private val clickonBuy:(product)->Unit
): RecyclerView.Adapter<AdapterProducts.viewHolderProduct>() {
    //SubClase
    class viewHolderProduct(itemView: View): RecyclerView.ViewHolder(itemView){
        val TXV_item_FRGProducts_Category: TextView=itemView.findViewById(R.id.TXV_item_FRGProducts_Category)
        val TXV_item_FRGProducts_Name: TextView=itemView.findViewById(R.id.TXV_item_FRGProducts_Name)
        val BTN_item_FRGProducts_Buy: Button=itemView.findViewById(R.id.BTN_item_FRGProducts_Buy)
        val IMV_item_FRGProductsImage: ImageView=itemView.findViewById(R.id.IMV_item_FRGProductsImage)
        val stringCategory=itemView.context.getString(R.string.category)
        val stringPrice=itemView.context.getString(R.string.price)



    }
    ////////
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProducts.viewHolderProduct {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.items_productoslist,parent,false)
        return viewHolderProduct(vista)
    }

    override fun onBindViewHolder(holder: AdapterProducts.viewHolderProduct, position: Int) {
        val product=productsList[position]
        holder.TXV_item_FRGProducts_Category.text=holder.stringCategory+": "+ product.category
        holder.TXV_item_FRGProducts_Name.text=holder.stringPrice+": " +product.name
        holder.BTN_item_FRGProducts_Buy.text= "${product.price}"
        holder.IMV_item_FRGProductsImage.setImageResource(R.drawable.ic_surmarket)
        holder.BTN_item_FRGProducts_Buy.setOnClickListener {
            clickonBuy(product)
        }

    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    fun notifyChanged(){
        notifyDataSetChanged()
    }

}