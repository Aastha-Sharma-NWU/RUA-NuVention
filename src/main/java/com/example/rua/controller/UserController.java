package com.example.rua.controller;

import com.example.rua.model.*;
import com.example.rua.repository.UserRepository;
import com.example.rua.service.SurveyService;
import com.example.rua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/rua/api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;
    private final SurveyService surveyService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, SurveyService surveyService) {
        this.userService = userService;
        this.surveyService = surveyService;
    }


    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();

    }

//------------old version---------
//    @PostMapping("/register")
//    public Status registerNewUser(@RequestBody Users user) throws IllegalAccessException {
//        return userService.registerNewUser(user);
//    }
    @PostMapping("/register")
    public Response registerNewUser(@RequestBody Users user) throws IllegalAccessException {
        return userService.registerNewUser(user);
    }

    //------------old version---------
//    @PostMapping("/login")
//    public Status loginUser(@Valid @RequestBody Users user) {
//        Users userObj = userRepository.findUserByContactNumber(user.getContactNumber());
//        if(null!=userObj ){
//            userObj.setLoggedIn(true);
//            userRepository.save(userObj);
//            return Status.SUCCESS;
//        }
//        return Status.FAILURE;
//    }
//       @PostMapping("/login")
//       public Response loginUser(@Valid @RequestBody Users user) {
//        Response response= new Response();
//            Users userObj = userRepository.findUserByContactNumber(user.getContactNumber());
//             if(null!=userObj ){
//                 if(user.getPassword().equals(userObj.getPassword())){
//                     userObj.setLoggedIn(true);
//                     userRepository.save(userObj);
//                     response.setStatus("Success");
//                     response.setMessage("User Successfully Logged In");
//                     return response;
//                 }else{
//                     response.setStatus("Failure");
//                     response.setMessage("Incorrect Password");
//                     return response;
//                 }
//
//    }
//           response.setStatus("Failure");
//           response.setMessage("User does not exists");
//           return response;
//}

    @PostMapping("/login")
    public Response loginUser(@Valid @RequestBody Users user) {
        Response response= new Response();
        Users currentUser = userRepository.findUserByContactNumber(user.getContactNumber());
        if(null!=currentUser ){
            if(user.getPassword().equals(currentUser.getPassword())){
                currentUser.setLoggedIn(true);
                userRepository.save(currentUser);

                String role=userService.getUserRole(user.getContactNumber());
                boolean isSurveyFilled=surveyService.isSurveyFilled(user.getContactNumber());
                response.setStatus("Success");
                response.setMessage("User Successfully Logged In");
                response.setRole(role);
                response.setSurveyCompleted(isSurveyFilled);
                return response;
            }else{
                response.setStatus("Failure");
                response.setMessage("Incorrect Password");
                return response;
            }

        }
        response.setStatus("Failure");
        response.setMessage("User does not exists");
        return response;
    }



//------------old version---------
//    @PostMapping("/logout")
//    public Status logUserOut(@Valid @RequestBody Users user) {
//        Users userObj = userRepository.findUserByContactNumber(user.getContactNumber());
//        if(null!=userObj){
//            userObj.setLoggedIn(false);
//            userRepository.save(userObj);
//            return Status.SUCCESS;
//        }
//        return Status.FAILURE;
//    }
    @PostMapping("/logout")
    public Response logUserOut(@Valid @RequestBody Users user) {
        Response response = new Response();
        Users userObj = userRepository.findUserByContactNumber(user.getContactNumber());
        if(null!=userObj){
            userObj.setLoggedIn(false);
            userRepository.save(userObj);
            response.setStatus("Success");
            response.setMessage("Logged Out Successfully");
            return response;
        }
        response.setStatus("Failure");
        response.setMessage("Logout failed");
        return response;
    }


//---------------old version
//    @GetMapping("/getUserRoleByContactNumber/{contactNumber}")
//    public String getUserRoleByContactNumber(@PathVariable String contactNumber){
//        return userService.getUserRoleByContactNumber(contactNumber);
//    }
    @GetMapping("/getUserRoleByContactNumber/{contactNumber}")
    public Response getUserRoleByContactNumber(@PathVariable String contactNumber){
        return userService.getUserRoleByContactNumber(contactNumber);
    }

//---------------old version
//    @PutMapping("/setUserRoleByContactNumber/{contactNumber}")
//    public Status setUserRoleByContactNumber(@RequestBody Users user,@PathVariable String contactNumber) {
//        return userService.setUserRoleByContactNumber(user,contactNumber);
//    }
     @PutMapping("/setUserRoleByContactNumber/{contactNumber}")
       public Response setUserRoleByContactNumber(@RequestBody Users user,@PathVariable String contactNumber) {
       return userService.setUserRoleByContactNumber(user,contactNumber);
     }


    @GetMapping("/getUserWeeklyLogs/{contactNumber}")
    public WeeklyLogs getUserWeeklyLogsByContactNumber(@PathVariable String contactNumber){
        return userService.getUserWeeklyLogsByContactNumber(contactNumber);
    }

    @GetMapping("/getActualVsPlannedCallLogs/{contactNumber}")
    public ActualVsPlannedLogs getActualVsPlannedCallLogsByContactNumber(@PathVariable String contactNumber){
        ActualVsPlannedLogs actualVsPlannedCallLogs= new ActualVsPlannedLogs();
        WeeklyLogs actualLogs=userService.getUserWeeklyLogsByContactNumber(contactNumber);
        SurveyDTO plannedLogs=surveyService.getSuggestedPlan(contactNumber);
        actualVsPlannedCallLogs.setActualAudioCalls(actualLogs.getAudioCalls());
        actualVsPlannedCallLogs.setActualVideoCalls(actualLogs.getVideoCalls());
        actualVsPlannedCallLogs.setActualTextMessages(actualLogs.getTextMessages());
        actualVsPlannedCallLogs.setPlannedAudioCalls(plannedLogs.getPlannedAudioCalls());
        actualVsPlannedCallLogs.setPlannedVideoCalls(plannedLogs.getPlannedVideoCalls());
        actualVsPlannedCallLogs.setPlannedTextMessages(plannedLogs.getPlannedTextMessages());
        actualVsPlannedCallLogs.setMessage(plannedLogs.getMessage());
        return actualVsPlannedCallLogs;
    }

//-------------------old version-----------
//    @PostMapping("/setUserWeeklyLogs/{contactNumber}")
//    public Status setUserWeeklyLogsByContactNumber(@RequestBody WeeklyLogs weekLogs, @PathVariable String contactNumber){
//         return userService.setUserWeeklyLogsByContactNumber(weekLogs,contactNumber);
//    }
    @PostMapping("/setUserWeeklyLogs/{contactNumber}")
      public Response setUserWeeklyLogsByContactNumber(@RequestBody WeeklyLogs weekLogs, @PathVariable String contactNumber){
      return userService.setUserWeeklyLogsByContactNumber(weekLogs,contactNumber);
    }

    //-------------------old version-----------
//    @PutMapping("/updateUserProfile/{contactNumber}")
//    public Status updateUserProfile(@RequestBody Users user,@PathVariable String contactNumber){
//        return userService.updateUserProfileByContactNumber(user,contactNumber);
//    }
    @PutMapping("/updateUserProfile/{contactNumber}")
    public Response updateUserProfile(@RequestBody Users user,@PathVariable String contactNumber){
        return userService.updateUserProfileByContactNumber(user,contactNumber);
    }

    //------old version
//    @PutMapping("/setUserFeedback/{contactNumber}")
//    public Status setUserFeedback(@RequestBody WeeklyLogs weeklyLogs,@PathVariable String contactNumber){
//        return userService.setUserFeedback(weeklyLogs,contactNumber);
//    }
@PutMapping("/setUserFeedback/{contactNumber}")
public Response setUserFeedback(@RequestBody WeeklyLogs weeklyLogs,@PathVariable String contactNumber){
    return userService.setUserFeedback(weeklyLogs,contactNumber);
}

}
