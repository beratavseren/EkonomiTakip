package com.example.demo.Controller;

import com.example.demo.Entity.Mudurluk;
import com.example.demo.Service.MudurlukService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mudurluk")
public class MudurlukController {

    MudurlukService mudurlukService=new MudurlukService();

    @PostMapping("/add")
    public boolean add(@RequestParam long bakanlik_id,@RequestParam int plaka_kodu,@RequestParam String mudurluk_ad,@RequestParam int gelir,@RequestParam int gider,@RequestParam int netgelir)
    {
        return mudurlukService.addMudurluk(bakanlik_id,plaka_kodu,new Mudurluk(mudurluk_ad,gelir,gider,netgelir));
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam long mudurluk_id)
    {
        return mudurlukService.deleteMudurluk(mudurluk_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam long mudurluk_id,@RequestParam int gelir,@RequestParam int gider,@RequestParam int netgelir)
    {
        return mudurlukService.updateMudurluk(mudurluk_id,new Mudurluk(gelir,gider,netgelir));
    }

    @GetMapping("/search")
    public Mudurluk search(@RequestParam long mudurluk_id)
    {
        return mudurlukService.searchMudurluk(mudurluk_id);
    }

    @GetMapping("/get")
    public List<Mudurluk> get()
    {
        return mudurlukService.getMudurluk();
    }
}
