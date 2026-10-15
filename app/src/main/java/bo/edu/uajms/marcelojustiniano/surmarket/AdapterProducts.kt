package bo.edu.uajms.marcelojustiniano.surmarket

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bo.edu.uajms.marcelojustiniano.surmarket.models.product

class AdapterProducts (
    private val productsList: List<product>,
    private val clickonBuy:(product)->Unit
): RecyclerView.Adapter<AdapterProducts.viewHolderProduct>() {
    //SubClase
    class viewHolderProduct(){

    }
    ////////
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProducts.viewHolderProduct {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AdapterProducts.viewHolderProduct, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}