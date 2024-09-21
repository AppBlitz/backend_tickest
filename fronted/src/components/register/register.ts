import { Users } from "../../interface/User/UserInterface.ts";

import { api } from "../../api/api.ts";

export const registerUser = (user: Users) => {
  console.log(user);
  api
    .post("/account/add", {
      fullName: user.fullName,
      email: user.email,
      address: user.address,
      password: user.password,
      phoneNumber: user.phoneNumber,
      identificationNumber: user.identificationNumber,
      bills: [{ nameUser: user.fullName }],
    })
    .catch((error) => {
      console.log("error" + error);
    })
    .finally();
};
