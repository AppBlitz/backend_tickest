import { User } from "../../interface/User/UserInterface.ts";

import { api } from "../../api/api.ts";
export const registerUser = (user: User) => {
  api
    .post("/account/add", {
      fullName: user.fullName,
      email: user.email,
      address: user.address,
      password: user.password,
      phoneNumber: user.phoneNumber,
      bills: [{ nameUser: user.fullName }],
    })
    .catch((error) => {
      console.error("Error registering user:", error);
    });
  console.log(user);
};
