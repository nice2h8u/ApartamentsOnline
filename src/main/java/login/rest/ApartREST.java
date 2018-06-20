package login.rest;

        import login.entity.Apart;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.security.Principal;
        import java.util.Date;

        import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/aparts/")
public class ApartREST {
    @Autowired
    private login.controller.IApartController apartController;

    @RequestMapping(value = "a", method = RequestMethod.GET)
    public ResponseEntity<Object> getAparts() {
        return ResponseEntity.ok(apartController.listAvaliableAparts());
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
