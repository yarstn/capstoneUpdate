package com.example.capstoneupdate.Service;

import com.example.capstoneupdate.Model.Category;
import com.example.capstoneupdate.Model.User;
import com.example.capstoneupdate.Repository.CateogryRepositry;
import com.example.capstoneupdate.Repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final UserService userService;
//    ArrayList<Category> categories = new ArrayList<>();
    private final UserRepositry userRepositry;
    private final CateogryRepositry cateogryRepositry;

    public List<Category> getCategories() {
        return cateogryRepositry.findAll();
    }

    public void addCategory(Integer userId, Category category) {
        User u = userRepositry.getReferenceById(userId);
      if (u != null) {
          if (u.getRole().equals("admin")) {
              cateogryRepositry.save(category);
          }
      }

//        User user = userService.getUser(userId);
//        if (user == null) {
//            return false;
//        }
//        if (user.getRole().equals("Admin")) {
//            categories.add(category);
//            return true;
//        }
//        return false;
    }

    public boolean updateCategory(Integer id, Category category) {
        User u = userRepositry.getReferenceById(id);
        if (u != null && "admin".equals(u.getRole())) {
            cateogryRepositry.save(category);
        }

        return false;
    }
    public boolean adminRemoveCategory(Integer userId, int id) {
        User u = userRepositry.getReferenceById(id);
        if (u != null) {
            if (u.getRole().equals("admin")) {
                cateogryRepositry.deleteById(id);
                return true;
            }
        }
        return false;

    }

//    public boolean deleteCategory(int id) {
//        for (int i = 0; i < categories.size(); i++) {
//            if (categories.get(i).getId() == id) {
//                categories.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }

//    //endpoint to check if the role is admin he can add category
//    public boolean adminAddCategory(int userId, Category category) {
//        User user = userService.getUser(userId);
//        if (user == null) {
//            return false;
//        }
//        if (user.getRole().equals("Admin")) {
//            categories.add(category);
//            return true;
//        }
//        return false;
//    }


}
