import { StateContext } from "../register/context/StateContext.tsx";
import { Auxiliar } from "../register/Auxiliar.tsx";
function Register() {
  return (
    <StateContext>
      <Auxiliar />
    </StateContext>
  );
}
export { Register };
