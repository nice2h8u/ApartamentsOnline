package login.rest;

import login.controller.IApartController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/apart/orders/")
public class OrderREST {

    @Autowired
    private IApartController apartController;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(apartController.listAllOrders());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> browse(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(apartController.findOrdersByApartId(id));
    }

//    @RequestMapping(value = "addNumer/{id}/{numerName}", method = RequestMethod.POST) //TODO: make add REST
//    public ResponseEntity<Object> add(@PathVariable(value = "numerName") String numerName,
//                                       // @PathVariable(value = "numerCost") Integer numerCost,
//                                         @PathVariable(value = "id") Integer id) {
//        return ResponseEntity.ok(apartController.addOrder(numerName, id));
//    }

    @RequestMapping(value = "delete/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable(value = "orderId") Integer orderId,
                              @AuthenticationPrincipal Principal principal) {
        if (principal == null) {
            throw new ForbiddenException();
        }
        apartController.deleteOrder(orderId);
    }
}
