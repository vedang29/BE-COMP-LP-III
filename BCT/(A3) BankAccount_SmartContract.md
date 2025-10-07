
# Simple Bank Account Smart Contract

This Solidity smart contract simulates a simple bank account for a customer, allowing them to deposit money, withdraw money, and check their balance. It is designed for deployment on a test network such as Ropsten, Rinkeby, or Goerli.

## Smart Contract Code

```solidity
// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankAccount {
    // Mapping to store balances of each customer
    mapping(address => uint256) private balances;

    // Event for deposit
    event Deposit(address indexed accountHolder, uint256 amount);

    // Event for withdrawal
    event Withdrawal(address indexed accountHolder, uint256 amount);

    // Deposit function to add money to the sender's account
    function deposit() public payable {
        require(msg.value > 0, "Deposit amount must be greater than 0");
        balances[msg.sender] += msg.value;
        emit Deposit(msg.sender, msg.value);
    }

    // Withdraw function to take money out of the sender's account
    function withdraw(uint256 _amount) public {
        require(_amount > 0, "Withdrawal amount must be greater than 0");
        require(balances[msg.sender] >= _amount, "Insufficient balance");
        balances[msg.sender] -= _amount;
        payable(msg.sender).transfer(_amount);
        emit Withdrawal(msg.sender, _amount);
    }

    // Function to check the balance of the sender's account
    function getBalance() public view returns (uint256) {
        return balances[msg.sender];
    }
}
```

## Deployment Instructions

1. Install [MetaMask](https://metamask.io/) and connect to a test network (Ropsten, Rinkeby, or Goerli).
2. Open [Remix IDE](https://remix.ethereum.org/).
3. Create a new Solidity file, e.g., `BankAccount.sol`, and paste the code above.
4. Compile the contract using Solidity `^0.8.0`.
5. Deploy the contract using the "Injected Web3" environment in Remix.
6. Use the deployed contract to:
   - Deposit Ether via the `deposit` function.
   - Withdraw Ether via the `withdraw` function.
   - Check balance via the `getBalance` function.

## Notes

- All amounts are in **Wei** (1 Ether = 10¹⁸ Wei).  
- This contract is meant for testing and learning purposes only; **do not use on the mainnet with real Ether**.  
- Events `Deposit` and `Withdrawal` help track transactions on the blockchain.
