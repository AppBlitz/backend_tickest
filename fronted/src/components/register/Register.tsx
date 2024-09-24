import { Input } from "@nextui-org/react";
import { useForm } from "react-hook-form";
import { registerUser } from "./register.ts";
import { Users } from "../../interface/User/UserInterface.ts";
function Register() {
  const { register, handleSubmit, formState: { errors } } = useForm<Users>();

  return (
    <>
      <form onSubmit={handleSubmit(registerUser)}>
        <div>
          <label>Nombre completo</label>
          <Input type="text" {...register("fullName", { required: true })} />
          {errors.fullName?.type === "required" && <p> El campo es requerido</p>}
        </div>
        <div>
          <label>Número de cedula</label>
          <Input
            type="text"
            {...register("identificationNumber", { required: true, maxLength: 10, min: 8 })}
          />
          {errors.identificationNumber?.type === "required" && <p> el campo es requerido</p>}
        </div>
        <div>
          <label>Correo electrónico</label>
          <Input type="email" {...register("email", { required: true, pattern: /^[^\s@]+@[^\s@]+\.[^\s@]+$/i })} />
          {errors.email?.type === "pattern" && <p> Correo eléctronico invalido revisar</p>}
          {errors.email?.type === "required" && <p>El cambo es requerido</p>}
        </div>
        <div>
          <label>Número de telefono</label>
          <Input type="text" {...register("phoneNumber", { required: true, min: 10 })} />
          {errors.phoneNumber?.type === "required" && <p>El campo es requerido</p>}
        </div>
        <div>
          <label>Dirección de residencia</label>
          <Input type="text" {...register("address", { required: true })} />
          {errors.address?.type === "required" && <p>El campo es requerido</p>}
        </div>
        <div>
          <label>Contraseña</label>
          <Input type="text" {...register("password", { required: true, min: 8, maxLength: 30 })} />
          {errors.password?.type === "required" && <p>El campo es requerido</p>}
          {errors.password?.type === "min" && <p> La contraseña no puede tener menos de 8 caracteres</p>}
          {errors.password?.type === "maxLength" && <p> La contraseña no puede tener una cantidad mayor de 30 caracteres</p>}
        </div>
        <button> Crear</button>
      </form>
    </>
  );
}
export { Register };
