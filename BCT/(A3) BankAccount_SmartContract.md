
# Simple Bank Account Smart Contract

This Solidity smart contract simulates a simple bank account for a customer, allowing them to deposit money, withdraw money, and check their balance. It is designed for deployment on a test network such as Ropsten, Rinkeby, or Goerli.

## Smart Contract Code

```solidity
// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract BankAccount {
    mapping(address => uint256) private balances;

    event Deposit(address indexed account, uint256 amount);
    event Withdraw(address indexed account, uint256 amount);

    function deposit() public payable {
        require(msg.value > 0, "Deposit amount must be greater than 0");
        balances[msg.sender] += msg.value;
        emit Deposit(msg.sender, msg.value);
    }

    function withdraw(uint256 amount) public {
        require(amount > 0, "Withdraw amount must be greater than 0");
        require(balances[msg.sender] >= amount, "Insufficient balance");

        balances[msg.sender] -= amount;
        payable(msg.sender).transfer(amount);

        emit Withdraw(msg.sender, amount);
    }

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
