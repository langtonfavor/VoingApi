package com.reactSpringboot1.SpringReactdemo.voteController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactSpringboot1.SpringReactdemo.exceptions.ResourceNotFoundException;
import com.reactSpringboot1.SpringReactdemo.modal.User;
import com.reactSpringboot1.SpringReactdemo.payLoads.PagedResponse;
import com.reactSpringboot1.SpringReactdemo.payLoads.UserIdentityAvailability;
import com.reactSpringboot1.SpringReactdemo.payLoads.UserProfile;
import com.reactSpringboot1.SpringReactdemo.payLoads.UserSummary;
import com.reactSpringboot1.SpringReactdemo.payLoads.VoteResponse;
import com.reactSpringboot1.SpringReactdemo.repository.UserRepository;
import com.reactSpringboot1.SpringReactdemo.repository.VoterRollRepository;
import com.reactSpringboot1.SpringReactdemo.repository.Voters;
import com.reactSpringboot1.SpringReactdemo.security.CurrentUser;
import com.reactSpringboot1.SpringReactdemo.security.UserPrincipal;
import com.reactSpringboot1.SpringReactdemo.service.VoteService;
import com.reactSpringboot1.SpringReactdemo.utils.AppConstants;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VoterRollRepository voteRollRepository;
	
	@Autowired
	private Voters voteRepository;
	
	@Autowired
	private VoteService voteService;
	
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getcurrentUser(@CurrentUser UserPrincipal currentUser) {
    	
    	UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
    	
    	return userSummary;
    }
    @GetMapping("/user/checkUserNameAvailabity")
    public UserIdentityAvailability checkUserNameAvailability(@RequestParam(value="username") String username){
    	
    Boolean isAvailable = !userRepository.existsByUsername(username);
    
    return new UserIdentityAvailability(isAvailable);
   
    }
    

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
}
    @GetMapping("/users/username")
    public UserProfile getUserProfile(@PathVariable(value="username") String username ) {
    	
    	User user = userRepository.findByUsername(username)
    			  .orElseThrow(() -> new ResourceNotFoundException("user", "username", username));
    			
    
    long voteCount = voteRepository.countByCreatedBy(user.getId());
    long voteRollCount = voteRollRepository.countByUserId(user.getId());
    
    UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt(), voteCount, voteRollCount);
    
     
    return userProfile;
    
    }
    
    @GetMapping("/users/{username}/votes")
    public PagedResponse<VoteResponse>getVoteCreatedBy(@PathVariable(value = "username") String username,
            @CurrentUser UserPrincipal currentUser,
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) { 
    	
    	 return voteService.getPollsCreatedBy(username, currentUser, page, size);
}
    @GetMapping("/users/{username}")
    public PagedResponse<VoteResponse>getVotesByVotedBy(@PathVariable(value="username") String name,
    													@CurrentUser UserPrincipal currentUser,
    													@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER)int page,
    													@RequestParam(value="size", defaultValue= AppConstants.DEFAULT_PAGE_SIZE)int size ){
        }
}
