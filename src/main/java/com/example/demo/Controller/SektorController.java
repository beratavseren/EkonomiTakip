package com.example.demo.Controller;

import com.example.demo.Entity.Sektor;
import com.example.demo.Service.SektorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sektor")
public class SektorController {
    SektorService sektorService=new SektorService();

    @PostMapping("/add")
    public boolean add(@RequestParam String sektor_ad, @RequestParam int vergi_orani,@RequestParam long ekonomi_id)
    {
        return sektorService.addSektor(new Sektor(ekonomi_id, vergi_orani, sektor_ad));
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam int sektor_id)
    {
        return sektorService.deleteSektor(sektor_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam long sektor_id,@RequestParam String yeni_sektor_ad,@RequestParam int yeni_vergi_orani)
    {
        return sektorService.updateSektor(sektor_id,new Sektor(yeni_sektor_ad,yeni_vergi_orani));
    }

    @GetMapping("/search")
    public Sektor search(@RequestParam long sektor_id)
    {
        return sektorService.searchSektor(sektor_id);
    }

    @GetMapping("/get")
    public List<Sektor> get()
    {
        return sektorService.getSektor();
    }
}
