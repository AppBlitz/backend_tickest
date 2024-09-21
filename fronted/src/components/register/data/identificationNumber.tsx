import { Input, Button } from "@nextui-org/react";

import React from "react";
import { UserContext } from "../context/UserContext.ts";
import { Users } from "../../../interface/User/UserInterface.ts";
import { useForm } from "react-hook-form";
const IdentificationNumber = () => {
  const { setUser } = React.useContext(UserContext);

  const { register, handleSubmit } = useForm<Users>();

  const addName = (identificationNumber: string) => {
    setUser((prev) => {
      return { ...prev, identificationNumber: identificationNumber };
    });
  };
  const addUser = (user: Users) => {
    addName(user.identificationNumber + "");
  };
  return (
    <>
      <div>
        <form onSubmit={handleSubmit(addUser)}>
          <label>Numero de identificación</label>
          <Input type="text" {...register("identificationNumber", {})} />
          <button>Click me</button>
        </form>
      </div>
    </>
  );
};
export { IdentificationNumber };
