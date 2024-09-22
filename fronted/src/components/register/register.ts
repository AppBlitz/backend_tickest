import { Users } from "../../interface/User/UserInterface.ts";

import { api } from "../../api/api.ts";

export const registerUser = (user: Users) => {
  api
    .post("/account/add", {
      fullName: user.fullName,
      email: user.email,
      address: user.address,
      password: user.password,
      phoneNumber: user.phoneNumber,
      identificationNumber: user.identificationNumber,
    })
    .catch((error) => {
      console.log("error" + error);
    })
    .finally();
};
