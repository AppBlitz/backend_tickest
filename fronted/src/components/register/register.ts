import { User } from "../../interface/UserInterface.ts";

import { api } from "../../interface/api.ts";
export const registerUser = (user: User) => {
  api
    .post("/account/add", {
      fullName: user.fullName,
      email: user.email,
      address: user.address,
      password: user.password,
      phoneNumber: user.phoneNumber,
      state: "ASSET",
    })
    .then((response) => {
      console.log("User registered successfully:", response.data);
    })
    .catch((error) => {
      console.error("Error registering user:", error);
    });
  console.log(user);
};
