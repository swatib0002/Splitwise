package Service.Impl;

import Repository.UserRepository;
import Service.IUserService;
import models.User;

import java.util.Map;

public class UserServiceImpl implements IUserService {
    @Override
    public User createUser(String name, String email, long number) {
        User user = new User(name,email,number);
        UserRepository.userMap.putIfAbsent(user.getUserId(),user);
        return user;
    }

     @Override
     public void showBalance(String userId){
        if(UserRepository.userBalanceMap.containsKey(userId)){
            for (Map.Entry<String, Double> userBalance : UserRepository.userBalanceMap.get(userId).entrySet()) {
                getBalance(userId,userBalance.getKey());
            }
        }else{
            System.out.println("No balances");
        }
    }

    private void getBalance(String user1, String user2) {
        Double balanceUser1 = UserRepository.userBalanceMap.get(user1).get(user2);
        Double balanceUser2 = UserRepository.userBalanceMap.get(user1).get(user2);
        Double amount = balanceUser1-balanceUser2;
        User u1 = (User) UserRepository.userBalanceMap.get(user1);
        User u2 = (User) UserRepository.userBalanceMap.get(user2);
        String user1Name = u1.getName();
        String user2Name = u2.getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }


}
