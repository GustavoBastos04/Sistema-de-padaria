import {Button} from "react-bootstrap";
import PropTypes from "prop-types";

function ItemProduto(props){
    return (
        <tr>
            <td>{props.nome}</td>
            <td>R${props.valor}</td>
            <td>{props.quantidade}</td>
        </tr>
    )
}

ItemProduto.propTypes = {
    nome: PropTypes.string.isRequired,
    valor: PropTypes.number.isRequired,
    quantidade: PropTypes.number.isRequired,
    flag: PropTypes.number.isRequired
}

export default ItemProduto;