package propensi.project.Assettrackr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import propensi.project.Assettrackr.model.dto.CreateRequest;
import propensi.project.Assettrackr.model.dto.ListUserResponse;
import propensi.project.Assettrackr.model.dto.LoginRequest;
import propensi.project.Assettrackr.model.dto.UserResponse;
import propensi.project.Assettrackr.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(CreateRequest request){
        try {
            String password = service.createUser(request);
            return ResponseEntity.ok(password);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(LoginRequest request){
        try {
            String jwt = service.login(request);
            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ListUserResponse> getAll(){
        ListUserResponse response = service.getAllUser();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getDetail(@PathVariable("id") String id){
        try {
            UserResponse response= service.getDetailUser(id);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

//    @GetMapping(value = "/manager/viewall")
//    public String listManager(Model model) {
//        List<ManagerModel> listManager = userService.getListManager();
//        model.addAttribute("listManager", listManager);
//        return "viewall-manager";
//    }
//
//    @GetMapping(value = "/manager/add")
//    public String addManagerFormPage(Model model) {
//        var manager = new ManagerModel();
//        List<IdolModel> listFreeIdol = userService.getListFreeIdol();
//        if (listFreeIdol.isEmpty()) listFreeIdol.add(new IdolModel());
//        model.addAttribute("listFreeIdol", listFreeIdol);
//        model.addAttribute("manager", manager);
//        return "form-add-manager";
//    }
//
//    @PostMapping(value = "/manager/add")
//    public String addManagerSubmit(@ModelAttribute ManagerModel manager, Model model) {
//        var message = "";
//        boolean isUsernameRegistered = userService.checkUsernameRegistered(manager.getUsername());
//        boolean isEmailRegistered = userService.checkEmailRegistered(manager.getEmail());
//        if(isUsernameRegistered || isEmailRegistered || !userService.isHaveFreeIdol()){
//            message = "Gagal Menambahkan Manager Karena akun pernah terdaftar atau tidak ada Idol yang bebas";
//            model.addAttribute("msg", message);
//            return "gagal-add";
//        }
//
//        SublabelModel sublabel = manager.getIdol().getSublabel();
//        manager.setSublabel(sublabel);
//        manager.setRole("Manager");
//        userService.addManager(manager);
//        message = "Berhasil menambahkan manager";
//        model.addAttribute("msg", message);
//        model.addAttribute("manager", manager);
//        return "add-manager";
//    }
//
//    @GetMapping(value = "/manager/delete/{id}")
//    public String deleteManager(@PathVariable String id, Model model) {
//        UserModel user = userService.getUserById(id);
//        userService.deleteUser(user);
//        return "delete";
//    }
//
//    @GetMapping(value = "/sales/viewall")
//    public String listSales(Model model) {
//        List<SalesModel> listSales = userService.getListSales();
//        model.addAttribute("listSales", listSales);
//        return "viewall-sales";
//    }
//
//    @GetMapping(value = "/sales/add")
//    public String addSalesFormPage(Model model) {
//        var sales = new SalesModel();
//        List<SublabelModel> listFreeSublabel = userService.getListFreeSublabelForSales();
//        if (listFreeSublabel.isEmpty()) {
//            listFreeSublabel.add(new SublabelModel());
//        }
//        model.addAttribute("listFreeSublabel", listFreeSublabel);
//        model.addAttribute("sales", sales);
//        return "form-add-sales";
//    }
//
//    @PostMapping(value = "/sales/add")
//    public String addSalesSubmit(@ModelAttribute SalesModel sales, Model model ) {
//        var message = "";
//        boolean isUsernameRegistered = userService.checkUsernameRegistered(sales.getUsername());
//        boolean isEmailRegistered = userService.checkEmailRegistered(sales.getEmail());
//        if (isUsernameRegistered || isEmailRegistered) {
//            message = "Gagal Menambahkan Sales Karena akun sudah pernah terdaftar";
//            model.addAttribute("msg", message);
//            return "gagal-add";
//        }
//        else if (sales.getSublabel() == null) {
//            message = "Gagal Menambahkan Sales Karena semua perusahaan telah memiliki sales";
//            model.addAttribute("msg", message);
//            return "gagal-add";
//        }
//        sales.setRole("Sales");
//        userService.addSales(sales);
//        message = "Berhasil menambahkan sales";
//        model.addAttribute("msg", message);
//        model.addAttribute("sales", sales);
//        return "add-sales";
//    }
//
//    @GetMapping(value = "/sales/delete/{id}")
//    public String deleteSales(@PathVariable String id, Model model) {
//        UserModel user = userService.getUserById(id);
//        userService.deleteUser(user);
//        return "delete";
//
//    }
//
//    @GetMapping(value = "/sponsor/viewall")
//    public String listSponsor(Model model) {
//        List<SponsorModel> listSponsor = userService.getListSponsor();
//        model.addAttribute("listSponsor", listSponsor);
//        return "viewall-sponsor";
//    }
//
//    @GetMapping(value = "/sponsor/add")
//    public String addSponsorFormPage(Model model) {
//        var sponsor = new SponsorModel();
//        model.addAttribute("sponsor", sponsor);
//        return "form-add-sponsor";
//    }
//
//    @PostMapping(value = "/sponsor/add")
//    public String addSponsorSubmit(@ModelAttribute SponsorModel sponsor,Model model) {
//        var message = "";
//        boolean isUsernameRegistered = userService.checkUsernameRegistered(sponsor.getUsername());
//        boolean isEmailRegistered = userService.checkEmailRegistered(sponsor.getEmail());
//        if(isUsernameRegistered || isEmailRegistered){
//            message = "Gagal menambah Sponsor karena akun sudah pernah terdaftar";
//            model.addAttribute("msg",message);
//            return "gagal-add";
//        }
//        sponsor.setRole("Sponsor");
//        userService.addSponsor(sponsor);
//        message = "Berhasil menambahkan sponsor";
//        model.addAttribute("msg", message);
//        model.addAttribute("sponsor", sponsor);
//        return "add-sponsor";
//    }
//
//    @GetMapping(value = "/sponsor/delete/{id}")
//    public String deleteSponsor(@PathVariable String id, Model model) {
//        UserModel user = userService.getUserById(id);
//        userService.deleteUser(user);
//        return "delete";
//    }
}