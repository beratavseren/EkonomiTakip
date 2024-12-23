package com.example.demo.Controller;

import com.example.demo.Entity.Bakanlik;
import com.example.demo.Service.BakanlikService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bakanlik")
public class BakanlikController {
    BakanlikService bakanlikService=new BakanlikService();

    @PostMapping("/add")
    public boolean add(@RequestParam String bakanlik_ad)
    {
        return bakanlikService.addBakanlik(new Bakanlik(bakanlik_ad));
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam long bakanlik_id)
    {
        return bakanlikService.deleteBakanlik(bakanlik_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam long bakanlik_id,@RequestParam String yeni_bakanlik_ad)
    {
        return bakanlikService.updateBakanlik(bakanlik_id,new Bakanlik(yeni_bakanlik_ad));
    }

    @GetMapping("/search")
    public Bakanlik search(@RequestParam long bakanlik_id)
    {
        return bakanlikService.searchBakanlik(bakanlik_id);
    }

    @GetMapping("/get")
    public List<Bakanlik> get()
    {
        return bakanlikService.getBakanlik();
    }
}
