package com.example.demo.Controller;

import com.example.demo.Entity.Ekonomi;
import com.example.demo.Service.EkonomiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ekonomi")
public class EkonomiController {

    EkonomiService ekonomiService=new EkonomiService();

    @PostMapping("/add")
    public boolean add(@RequestParam String ekonomi_ad)
    {
        return ekonomiService.addEkonomi(new Ekonomi(ekonomi_ad));
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam long ekonomi_id)
    {
        return ekonomiService.deleteEkonomi(ekonomi_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam long ekonomi_id,@RequestParam String yeni_ekonomi_ad)
    {
        return ekonomiService.updateEkonomi(ekonomi_id,new Ekonomi(yeni_ekonomi_ad));
    }

    @GetMapping("/search")
    public Ekonomi search(@RequestParam long ekonomi_id)
    {
        return ekonomiService.searchEkonomi(ekonomi_id);
    }

    @GetMapping("/get")
    public List<Ekonomi> get()
    {
        return ekonomiService.getEkonomi();
    }
}
