import { Input } from "@nextui-org/react";
import React from "react";
import { UserContext } from "../context/UserContext";
import { useForm } from "react-hook-form";
import { Users } from "../../../interface/User/UserInterface.ts";

const Email = () => {
  const { setUser } = React.useContext(UserContext);
  const { register, handleSubmit } = useForm<Users>();

  const addName = (email: string) => {
    setUser((prev) => {
      return { ...prev, email };
    });
  };

  const addUser = (user: Users) => {
    addName(user.email + "");
  };

  return (
    <div>
      <form onSubmit={handleSubmit(addUser)}>
        <label>Correo</label>
        <Input
          type="text"
          className="max-w-xs"
          {...register("email", { required: true })}
        />
        <button type="submit">Enviar</button>
      </form>
    </div>
  );
};

export { Email };
