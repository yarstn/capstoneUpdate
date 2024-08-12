package com.example.capstoneupdate.Service;

import com.example.capstoneupdate.Model.Merchant;
import com.example.capstoneupdate.Repository.MarchentRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MerchantService {
//    ArrayList<Merchant> merchants = new ArrayList<Merchant>();
private final MarchentRepositry marchentRepositry;
    public List<Merchant> getMerchants() {
        return marchentRepositry.findAll();
    }
    public void addMerchant(Merchant merchant) {
     marchentRepositry.save(merchant);
    }
    public boolean updateMerchant(Integer id,Merchant merchant) {
        for (Merchant merchant1 : marchentRepositry.findAll()) {
            if (merchant1.getId() == id) {
                merchant1.setName(merchant.getName());
                return true;
            }
        }
        return false;

    }
    public boolean deleteMerchant(Integer id) {
      Merchant c = marchentRepositry.getReferenceById(id);
      if (c != null) {
          marchentRepositry.delete(c);
          return true;
      }
      return false;
    }

    public Merchant getMerchantById(Integer id) {
        return marchentRepositry.getReferenceById(id);

    }
}
