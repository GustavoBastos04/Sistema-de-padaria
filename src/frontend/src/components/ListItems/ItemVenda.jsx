import PropTypes from "prop-types";

function ItemVenda(props){
    return (
        <tr>
            <td>{props.id_venda}</td>
            <td>{props.valor}</td>
            <td>{props.data}</td>
        </tr>
    )
}

ItemVenda.propTypes = {
    id_venda: PropTypes.number.isRequired,
    valor: PropTypes.number.isRequired,
    data: PropTypes.string.isRequired,
    flag: PropTypes.number.isRequired
}

export default ItemVenda;