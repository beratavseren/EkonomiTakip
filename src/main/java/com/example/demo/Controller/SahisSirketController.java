package com.example.demo.Controller;


import com.example.demo.Entity.SahisSirket;
import com.example.demo.Entity.Sirket;
import com.example.demo.Service.SahisSirketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sahissirket")
public class SahisSirketController {

    SahisSirketService sahisSirketService=new SahisSirketService();

    @PostMapping("/add")
    public boolean add(@RequestParam String isim,@RequestParam String soyisim,@RequestParam String sirket_ad,@RequestParam int gelir,@RequestParam int gider,@RequestParam int vergi_borcu,@RequestParam long sektor_id,@RequestParam int plaka_kodu)
    {
        return sahisSirketService.addSahisSirket(new SahisSirket(isim,soyisim,sirket_ad,gelir,gider,vergi_borcu),sektor_id,plaka_kodu);
    }

    @PostMapping("/addwithpaydasid")
    public boolean addwithpaydasid(@RequestParam long paydas_id,@RequestParam String sirket_ad,@RequestParam int gelir,@RequestParam int gider,@RequestParam int vergi_borcu,@RequestParam long sektor_id,@RequestParam int plaka_kodu)
    {
        SahisSirket sahisSirket=new SahisSirket();
        sahisSirket.setSirket(new Sirket(sirket_ad,gelir,gider,vergi_borcu));
        return sahisSirketService.addSahisSirketwithpaydas_id(paydas_id,sahisSirket,sektor_id,plaka_kodu);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam long sahissirket_id)
    {
        return sahisSirketService.deleteSahisSirket(sahissirket_id);
    }

    @PostMapping("/updatePaydas")
    public boolean updatePaydas(@RequestParam long sahissirket_id,@RequestParam long paydas_id)
    {
        return sahisSirketService.updateSahisSirketPaydas(sahissirket_id,paydas_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam String guncellenecek_sirket_ad,@RequestParam int gelir,@RequestParam int gider,@RequestParam int vergi_borcu)
    {
        return sahisSirketService.updateSahisSirket(new Sirket(guncellenecek_sirket_ad,gelir,gider,vergi_borcu));
    }

    @GetMapping("/search")
    public SahisSirket search(@RequestParam long sahissirket_id)
    {
        return sahisSirketService.searchSahisSirket(sahissirket_id);
    }

    @GetMapping("/get")
    public List<SahisSirket> get()
    {
        return sahisSirketService.getSahisSirket();
    }
}
