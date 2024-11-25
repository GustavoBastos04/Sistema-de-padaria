import {Button} from "react-bootstrap";
import PropTypes from "prop-types";
import '../ProfitModal/ProfitModal'
import { useState } from "react";
import ProfitModal from "../ProfitModal/ProfitModal";

function ItemProduto(props){

    const [show, setShow] = useState(false)

    const handleChange = () => {
        setShow(!show)
    }

    return (
        <>
            <ProfitModal show={show} onClose={handleChange} props={props}/>
            <tr>
                <td>{props.nome}</td>
                <td>R${props.valor}</td>
                <td>{props.quantidade}</td>
                <td className="text-end">
                    { props.flag === 1 && (
                        <>
                            <Button variant="success" className="m-1" onClick={() => setShow(!show)}>Visualizar lucro</Button>
                        </>
                    )}
                </td>
            </tr>
        </>
    )
}

ItemProduto.propTypes = {
    nome: PropTypes.string.isRequired,
    valor: PropTypes.number.isRequired,
    quantidade: PropTypes.number.isRequired,
    flag: PropTypes.number.isRequired
}

export default ItemProduto;