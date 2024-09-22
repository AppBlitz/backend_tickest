import { StateContext } from "../register/context/StateContext.tsx";
import { Aux } from "../register/Aux.tsx";
function Register() {
  return (
    <StateContext>
      <Aux />
    </StateContext>
  );
}
export { Register };
