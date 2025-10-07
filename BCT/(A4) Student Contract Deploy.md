# Solidity Student Data Smart Contract

## Overview
This tutorial demonstrates how to create a simple Ethereum smart contract to store student data using **structures**, **arrays**, and a **fallback function**. We will also deploy it on a test network and observe gas consumption and transaction fees.

---

## Step 1: Solidity Smart Contract Code

```solidity
// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract StudentContract {

    // Structure to store student information
    struct Student {
        uint id;
        string name;
        uint age;
    }

    // Array to store multiple students
    Student[] public students;

    // Event to log student addition
    event StudentAdded(uint id, string name, uint age);

    // Function to add a new student
    function addStudent(uint _id, string memory _name, uint _age) public {
        Student memory newStudent = Student({
            id: _id,
            name: _name,
            age: _age
        });
        students.push(newStudent);
        emit StudentAdded(_id, _name, _age);
    }

    // Function to get total number of students
    function getStudentCount() public view returns (uint) {
        return students.length;
    }

    // Function to get student details by index
    function getStudent(uint index) public view returns (uint, string memory, uint) {
        require(index < students.length, "Student does not exist");
        Student memory s = students[index];
        return (s.id, s.name, s.age);
    }

    // Fallback function
    fallback() external payable {
        // Can be used to receive ether or handle unknown function calls
    }

    // Receive function to accept Ether directly
    receive() external payable {}
}
```

---

## Step 2: Set Up Environment

1. Install [Node.js](https://nodejs.org/) and [npm](https://www.npmjs.com/).
2. Install [MetaMask](https://metamask.io/) and create a wallet.
3. Fund your wallet with test Ether from a test network faucet (e.g., Goerli or Sepolia testnet).

---

## Step 3: Deploy Using Remix IDE

1. Open [Remix IDE](https://remix.ethereum.org/).
2. Create a new file `StudentContract.sol` and paste the above code.
3. Select the **Solidity Compiler** tab:
    - Compiler version: `0.8.20` or compatible
    - Click **Compile**
4. Go to the **Deploy & Run Transactions** tab:
    - Environment: **Injected Web3** (connects to MetaMask)
    - Account: Select your test network wallet
    - Contract: `StudentContract`
5. Click **Deploy** and confirm the transaction in MetaMask.

---

## Step 4: Interact with the Contract

- **Add a Student**
    - Call `addStudent(_id, _name, _age)` from Remix
    - Observe the transaction confirmation in MetaMask
- **Get Student Count**
    - Call `getStudentCount()`
- **Get Student Details**
    - Call `getStudent(index)`

---

## Step 5: Observe Gas and Transaction Fees

1. In Remix, after deploying or calling a function:
    - Open the **Terminal/Console**
    - You will see **Gas Used**, **Transaction Hash**, and **Status**
2. In MetaMask:
    - Check the **Transaction Details**
    - Observe the **Gas Fee** and **Total Fee** paid for execution

> Note: Gas cost varies depending on the function complexity and network congestion.

---

## Step 6: Sending Ether

- The contract has a `fallback()` and `receive()` function to accept Ether.
- You can send test Ether directly to the contract address from MetaMask.
- Observe the gas fee for receiving Ether.

---

## Step 7: Summary

- This contract demonstrates:
  - **Structures** to define student data
  - **Arrays** to store multiple students
  - **Fallback and receive functions** to handle Ether or unknown calls
- Gas fees and transaction costs can be monitored via Remix and MetaMask.

---

## References

- [Solidity Documentation](https://docs.soliditylang.org/)
- [Remix IDE](https://remix.ethereum.org/)
- [Ethereum Testnets](https://ethereum.org/en/developers/docs/networks/)