package login.rest;

        import com.fasterxml.jackson.databind.util.JSONPObject;
        import com.google.gson.JsonObject;
        import login.classes.Login;
        import login.classes.LoginService;
        import login.classes.LoginServiceImpl;
        import login.entity.Apart;
        import login.entity.User;
        import login.rest.Entity.FilterApart;
        import login.rest.Entity.FilterPar;
        import login.rest.Entity.FilterUser;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.format.annotation.DateTimeFormat;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.core.Authentication;
        import org.springframework.web.bind.annotation.*;

        import java.security.Principal;
        import java.sql.Date;
        import java.time.LocalDate;
        import java.util.List;
        import java.util.logging.Filter;


        import org.springframework.security.core.annotation.AuthenticationPrincipal;


@RestController
@RequestMapping("/aparts/")
public class ApartREST {
    @Autowired
    private login.controller.IApartController apartController;







@RequestMapping(value = "find_available_aparts", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> getApartList(@RequestBody FilterPar filterPar) {
    System.out.println(filterPar.getDate_begin()+" "+filterPar.getApart_cost()+"  "+filterPar.getApart_city());
    return ResponseEntity.ok(apartController.listAvaliableAparts(filterPar.getDate_begin(),filterPar.getDate_end(),
            filterPar.getApart_cost(),filterPar.getApart_city()));
}


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Apart> browse() {


        return apartController.listAllAparts();
    }

    @RequestMapping(value = "add/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> add(@RequestBody FilterApart f, @AuthenticationPrincipal Principal principal) {
        if (principal == null) {
            throw new ForbiddenException();
        }
        Apart apart = new Apart(f.getApart_name(),
                f.getApart_city(),f.getApart_address(),f.getApart_phone(),
                f.getApart_x(),f.getApart_y(),f.getApart_cost(),f.getApart_description(),f.getApart_image_url());

        Login login= (Login)(((Authentication) principal).getPrincipal());
        return ResponseEntity.ok(apartController.add(apart));
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteApart(@PathVariable(value = "id") Integer id,
                              @AuthenticationPrincipal Principal principal) {
        if (principal == null) {
            throw new ForbiddenException();
        }
        apartController.deleteApart(id);
    }


}
