# Solidity Student Data Smart Contract

## Overview
This tutorial demonstrates how to create a simple Ethereum smart contract to store student data using **structures**, **arrays**, and a **fallback function**. We will also deploy it on a test network and observe gas consumption and transaction fees.

---

## Step 1: Solidity Smart Contract Code

```solidity
// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract StudentData {
    struct Student {
        uint256 id;
        string name;
        uint8 age;
        string course;
    }

    Student[] private students;

    event StudentAdded(uint256 id, string name, string course);
    event FallbackCalled(address sender, uint value, string message);

    function addStudent(uint256 _id, string memory _name, uint8 _age, string memory _course) public {
        students.push(Student(_id, _name, _age, _course));
        emit StudentAdded(_id, _name, _course);
    }

    function getStudent(uint256 index) public view returns (uint256, string memory, uint8, string memory) {
        require(index < students.length, "Invalid index");
        Student memory s = students[index];
        return (s.id, s.name, s.age, s.course);
    }

    function getTotalStudents() public view returns (uint256) {
        return students.length;
    }

    fallback() external payable {
        emit FallbackCalled(msg.sender, msg.value, "Fallback function triggered!");
    }

    receive() external payable {
        emit FallbackCalled(msg.sender, msg.value, "Receive function triggered!");
    }
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