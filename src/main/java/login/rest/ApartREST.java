package login.rest;

        import login.entity.Apart;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.format.annotation.DateTimeFormat;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.security.Principal;
        import java.sql.Date;
        import java.time.LocalDate;


        import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/aparts/")
public class ApartREST {
    @Autowired
    private login.controller.IApartController apartController;
//http://localhost:8080/aparts/a?date_begin=2018-06-10&date_end=2018-06-11
    @RequestMapping(value = "a", method = RequestMethod.GET)
    public ResponseEntity<Object> getAparts(@RequestParam("date_begin")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date_begin,
                                            @RequestParam("date_end")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date_end) {
        return ResponseEntity.ok(apartController.listAvaliableAparts(new Date(0,0,0).valueOf(LocalDate.of(date_begin.getYear(),date_begin.getMonth(),date_begin.getDayOfMonth())),
                new Date(0,0,0).valueOf(LocalDate.of(date_end.getYear(),date_end.getMonth(),date_end.getDayOfMonth()))));
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
