package salas.ian.mydigimind.ui.dashboard

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import salas.ian.mydigimind.R
import salas.ian.mydigimind.databinding.FragmentDashboardBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        val root: View = inflater.inflate(R.layout.fragment_dashboard,container,false)
        val btn_time:Button = root.findViewById(R.id.btn_time)

        btn_time.setOnClickListener {
        val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener{timePicker,hour,minute->
                cal.set(Calendar.HOUR_OF_DAY,hour)
                cal.set(Calendar.MINUTE,minute)

                btn_time.text=SimpleDateFormat("HH:mm").format(cal.time)
            }
        TimePickerDialog(root.context,timeSetListener,cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),true).show()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}