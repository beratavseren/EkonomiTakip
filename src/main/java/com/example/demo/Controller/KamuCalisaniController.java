package com.example.demo.Controller;

import com.example.demo.Entity.KamuCalisani;
import com.example.demo.Service.KamuCalisaniService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kamucalisani")
public class KamuCalisaniController {
    KamuCalisaniService kamuCalisaniService=new KamuCalisaniService();

    @PostMapping("/add")
    public boolean add(@RequestParam String isim,@RequestParam String soyisim,@RequestParam long mudurluk_id,@RequestParam int plaka_kodu,@RequestParam int maas)
    {
        return kamuCalisaniService.addKamuCalisani(new KamuCalisani(isim,soyisim),mudurluk_id,plaka_kodu,maas);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam long kamu_calisani_id)
    {
        return kamuCalisaniService.deleteKamuCalisani(kamu_calisani_id);
    }

    @PostMapping("/update")
    public boolean update(@RequestParam long kamu_calisani_id,@RequestParam int maas)
    {
        return kamuCalisaniService.updateKamuCalisani(kamu_calisani_id,maas);
    }

    @GetMapping("/search")
    public KamuCalisani search(@RequestParam long kamu_calisani_id)
    {
        return kamuCalisaniService.searchKamuCalisani(kamu_calisani_id);
    }

    @GetMapping("/get")
    public List<KamuCalisani> get()
    {
        return kamuCalisaniService.getKamuCalisani();
    }
}
