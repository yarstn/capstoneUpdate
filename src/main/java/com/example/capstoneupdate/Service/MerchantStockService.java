package com.example.capstoneupdate.Service;

import com.example.capstoneupdate.Model.MerchantStock;
import com.example.capstoneupdate.Repository.MarchentRepositry;
import com.example.capstoneupdate.Repository.MarchentStockRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class MerchantStockService {
//    ArrayList<MerchantStock> merchantStockList = new ArrayList<MerchantStock>();
    private final MarchentStockRepositry marchentStockRepositry;

    public List<MerchantStock> getMerchantStockList() {
        return marchentStockRepositry.findAll();
    }
    public void addMerchantStock(MerchantStock merchantStock) {
        marchentStockRepositry.save(merchantStock);
    }

    public  boolean updateMerchantStock(Integer id,MerchantStock merchantStock) {
       MerchantStock s = marchentStockRepositry.getReferenceById(id);
       if (s != null && merchantStock.getId().equals(s.getId())) {
           s.setStock(s.getStock() + merchantStock.getStock());
           marchentStockRepositry.save(s);
           return true;
       }
       return false;
    }


    public boolean deleteMerchantStock(Integer id) {
    MerchantStock d = marchentStockRepositry.getReferenceById(id);
    if (d != null) {
        marchentStockRepositry.delete(d);
        return true;
    }
    return false;
    }

    public MerchantStock getMerchantStock(Integer id) {
        return marchentStockRepositry.getReferenceById(id);
    }

    //user can add more stocks of product to a merchant
    //Stock
    public boolean changeMerchantStock(int merchantId, int productId, int amount, MerchantStock merchantStock) {
        MerchantStock d = marchentStockRepositry.getReferenceById(merchantId);
        if (d != null && merchantStock.getId().equals(d.getId())) {
            d.setStock(d.getStock() + amount);
            marchentStockRepositry.save(d);
            return true;
        }
        return false;
    }
//        for (MerchantStock stock : merchantStockList) {
//            if (stock.getMerchantId() == merchantId && stock.getProductId() == productId) {
//                stock.setStock(stock.getStock() + amount);
//                return true;
//            }
//        }
//        return false;

}
