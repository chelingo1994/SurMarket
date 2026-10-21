package bo.edu.uajms.marcelojustiniano.surmarket

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bo.edu.uajms.marcelojustiniano.surmarket.models.product

class FragmentProductsList : Fragment() {
    private lateinit var IMV_FRGProductsList_ShoppingCart: ImageView
    private lateinit var IMV_FRGProductsList_Search: ImageView
    private lateinit var ETX_FRGProductsList_Search: EditText
    private lateinit var btn_FRGProductsList: Button
    private lateinit var RCV_FRGProductsList: RecyclerView
    private lateinit var adapterProducts: AdapterProducts
    private var listaproductos=mutableListOf<product>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        configureListeners()
        configureReciclyView()
        loadSampleProducts()
    }

    private fun initializeViews(view: View) {
        IMV_FRGProductsList_ShoppingCart=view.findViewById(R.id.IMV_FRGProductsList_ShoppingCart)
         IMV_FRGProductsList_Search=view.findViewById(R.id.IMV_FRGProductsList_Search)
         ETX_FRGProductsList_Search=view.findViewById(R.id.ETX_FRGProductsList_Search)
         btn_FRGProductsList=view.findViewById(R.id.btn_FRGProductsList)
        RCV_FRGProductsList=view.findViewById(R.id.RCV_FRGProductsList)
    }

    private fun configureListeners(){

    }
    private  fun configureReciclyView(){
        adapterProducts= AdapterProducts(
            productsList = listaproductos,
            clickonBuy = { product->
                Toast.makeText(requireContext(), getString(R.string.addCart)+" "+product.name, Toast.LENGTH_SHORT).show()
            }
        )
        RCV_FRGProductsList.apply {
            layoutManager= LinearLayoutManager(requireContext())
            adapter=adapterProducts
        }
    }
    private fun loadSampleProducts(){
        val productsSample=listOf(
            product(
                id=1,
                name = "Camisa",
                category = "Ropa de Varon",
                price = 180.0,
                imageUrlval = "",
                description = "Camisa de Varon Tomy",
                available = true,
                stock = 1
            ),
            product(
                id=2,
                name = "Pantalo",
                category = "Ropa de Varon",
                price = 210.0,
                imageUrlval = "",
                description = "Pantalon de Jean Azul",
                available = true,
                stock = 1
            ),
            product(
                id=3,
                name = "Polera",
                category = "Ropa de Varon",
                price = 160.0,
                imageUrlval = "",
                description = "Polera Polo",
                available = true,
                stock = 1
            ),
            product(
                id=4,
                name = "Zapatilla",
                category = "Ropa de Varon",
                price = 530.0,
                imageUrlval = "",
                description = "Nike Blanca",
                available = true,
                stock = 1
            ),
            product(
                id=1,
                name = "Zapatos",
                category = "Ropa de Varon",
                price = 250.0,
                imageUrlval = "",
                description = "Zapato Negro",
                available = true,
                stock = 1
            )
        )
        listaproductos.clear()
        listaproductos.addAll(productsSample)
        adapterProducts.notifyChanged()
    }
}
