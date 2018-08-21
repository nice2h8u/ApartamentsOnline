package login.rest;

        import login.entity.Apart;
        import login.rest.Entity.FilterPar;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.format.annotation.DateTimeFormat;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.security.Principal;
        import java.sql.Date;
        import java.time.LocalDate;
        import java.util.logging.Filter;


        import org.springframework.security.core.annotation.AuthenticationPrincipal;


@RestController
@RequestMapping("/aparts/")
public class ApartREST {
    @Autowired
    private login.controller.IApartController apartController;



//http://localhost:8080/aparts/a?date_begin=2018-06-10&date_end=2018-06-11
    @RequestMapping(value = "find_available_aparts", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getApartList(@RequestBody FilterPar filterPar) {
            return ResponseEntity.ok(apartController.listAvaliableAparts(filterPar.getDate_begin(),filterPar.getDate_end()));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(apartController.listAllAparts());
    }

    @RequestMapping(value = "add/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> add(@RequestBody Apart apart, @AuthenticationPrincipal Principal principal) {
        if (principal == null) {
            throw new ForbiddenException();
        }
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
