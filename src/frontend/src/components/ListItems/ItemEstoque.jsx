import PropTypes from "prop-types";
import { format } from "date-fns"

function ItemEstoque(props){
    return (
        <tr>
            <td>{props.nome}</td>
            <td>{props.quantidade}</td>
            <td>{format(props.data_validade, 'dd/MM/yyyy')}</td>
        </tr>
    )
}

ItemEstoque.propTypes = {
    nome: PropTypes.string.isRequired,
    quantidade: PropTypes.string.isRequired,
    data_validade: PropTypes.any.isRequired,
    flag: PropTypes.number.isRequired
}

export default ItemEstoque;