package com.example.demo.Controller;

import com.example.demo.Entity.Paydas;
import com.example.demo.Service.PaydasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paydas")
public class PaydasController {
    PaydasService paydasService=new PaydasService();

    @PostMapping("/add")
    public boolean add(@RequestParam String isim,@RequestParam String soyisim)
    {
        return paydasService.addPaydas(new Paydas(isim,soyisim));
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam long paydas_id)
    {
        return paydasService.deletePaydas(paydas_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam long paydas_id,@RequestParam String isim, @RequestParam String soyisim)
    {
        return paydasService.updatePaydas(paydas_id,new Paydas(isim,soyisim));
    }

    @GetMapping("/search")
    public Paydas search(@RequestParam long paydas_id)
    {
        return paydasService.searchPaydas(paydas_id);
    }

    @GetMapping("/get")
    public List<Paydas> get()
    {
        return paydasService.getPaydas();
    }
}
